// Assignment Question:
// 💻 Direct Questions:
Bas apna assignment question raw text me bhejo (e.g., "Write a Java program for multithreading"). Bot khud code likhega, local PC pe compile karega, aur pass hone par GitHub pe upload karega.

📜 Syllabus Kaise Upload Karein (Step-by-Step):

Telegram par bhejo: /renew

Bot puchega: "Do you want to renew the syllabus?" -> Reply karo: YES

Bot puchega: "Please send or paste your NEW SYLLABUS text now."

Apna pura raw syllabus text copy karke Telegram par bhej do. Bot usko topic-by-topic tod kar sequentially solve karna shuru kar dega.

🛠️ System Commands:

/renew - Naya syllabus set ya upload karne ke liye (3-step confirmation flow).

/upload_one_more - Agar daily 6 uploads ki limit hit ho gayi hai aur ek urgent code push karna hai, toh ye command bhejo (+1 bypass).

/removejustuploadedcode - 🚨 KILLSWITCH: Agar bot ne galat code push kar diya hai, toh preview aane ke 5 minute ke andar ye bhejo. Ye file ko local PC aur GitHub repo dono se hamesha ke liye uda dega.

⚙️ System Rules:

Limit: Maximum 6 uploads per day (Midnight reset).

3-Strike Rule: Agar koi code 3 baar compilation me fail hota hai, toh API tokens bachane ke liye wo question permanent blacklist ho jayega.

Manual Override: PC par turant bot start/kill karne ke liye desktop ke Start_Moltbot.bat ya Stop_Moltbot.bat buttons use karo.
// Author: Ansh Pandey

**Direct Questions Bot**
=======================

### Prerequisites

* Python 3.8+
* Required libraries: `tkinter`, `argparse`, `requests`, `git`
* GitHub API token
* Local PC with desktop access

### Bot Code

import tkinter as tk
from tkinter import scrolledtext
import argparse
import requests
import subprocess
import os
import time
import threading
import random

# API tokens
GITHUB_TOKEN = "YOUR_GITHUB_TOKEN"  # Replace with your GitHub API token
GITHUB_REPO = "YOUR_REPO"  # Replace with your GitHub repository name

# Bot settings
MAX_UPLOADS_PER_DAY = 6
THREE_STRIKE_LIMIT = 3

class MoltBot:
    def __init__(self):
        self.window = tk.Tk()
        self.window.title("MoltBot")
        self.question = tk.StringVar()
        self.answer = tk.StringVar()
        self.code = tk.StringVar()
        self.github_url = tk.StringVar()

        self.question_label = tk.Label(self.window, text="Question:")
        self.question_label.pack()
        self.question_entry = tk.Entry(self.window, textvariable=self.question)
        self.question_entry.pack()

        self.answer_label = tk.Label(self.window, text="Answer:")
        self.answer_label.pack()
        self.answer_entry = tk.Entry(self.window, textvariable=self.answer)
        self.answer_entry.pack()

        self.code_label = tk.Label(self.window, text="Code:")
        self.code_label.pack()
        self.code_entry = tk.Text(self.window, height=10, width=50, textvariable=self.code)
        self.code_entry.pack()

        self.github_url_label = tk.Label(self.window, text="GitHub URL:")
        self.github_url_label.pack()
        self.github_url_entry = tk.Entry(self.window, textvariable=self.github_url)
        self.github_url_entry.pack()

        self.upload_button = tk.Button(self.window, text="Upload", command=self.upload_code)
        self.upload_button.pack()

        self.remove_button = tk.Button(self.window, text="Remove", command=self.remove_code)
        self.remove_button.pack()

        self.status_label = tk.Label(self.window, text="")
        self.status_label.pack()

        self.question_history = {}

    def upload_code(self):
        question = self.question.get()
        answer = self.answer.get()
        code = self.code_entry.get("1.0", "end-1c")
        github_url = self.github_url.get()

        if not question or not answer or not code or not github_url:
            self.status_label.config(text="Please fill all fields.")
            return

        # Check upload limit
        if self.upload_limit() >= MAX_UPLOADS_PER_DAY:
            self.status_label.config(text="Upload limit exceeded. Please use /upload_one_more.")
            return

        # Check code syntax
        try:
            self.compile_code(code)
        except Exception as e:
            self.status_label.config(text=str(e))
            return

        # Upload code to GitHub
        self.upload_to_github(github_url, code)

        # Save question history
        self.question_history[question] = (answer, code)

        self.status_label.config(text="Code uploaded successfully.")

    def remove_code(self):
        question = self.question.get()
        github_url = self.github_url.get()

        if not question or not github_url:
            self.status_label.config(text="Please fill all fields.")
            return

        # Remove code from GitHub
        self.remove_from_github(github_url)

        self.status_label.config(text="Code removed successfully.")

    def upload_to_github(self, github_url, code):
        # Get repository path from GitHub URL
        repo_path = github_url.split("/").[-1]

        # Clone repository
        subprocess.run(["git", "clone", github_url, repo_path])

        # Create new file
        with open(f"{repo_path}/new_code.py", "w") as file:
            file.write(code)

        # Commit and push changes
        subprocess.run(["git", "add", f"{repo_path}/new_code.py"], cwd=repo_path)
        subprocess.run(["git", "commit", "-m", "New code.", "-a"], cwd=repo_path)
        subprocess.run(["git", "push", "origin", f"HEAD:{GITHUB_REPO}"], cwd=repo_path)

    def remove_from_github(self, github_url):
        # Get repository path from GitHub URL
        repo_path = github_url.split("/").[-1]

        # Remove repository
        subprocess.run(["git", "rm", f"{repo_path}"], cwd="/")

        # Remove directory
        subprocess.run(["rm", f"{repo_path}"])

    def compile_code(self, code):
        # Compile code
        try:
            exec(code)
        except Exception as e:
            raise Exception(f"Compilation failed: {str(e)}")

    def upload_limit(self):
        # Get current date
        today = time.strftime("%Y-%m-%d")

        # Count uploads
        count = len([filename for filename in os.listdir("histories") if filename.startswith(today)])

        return count

    def run_bot(self):
        self.window.mainloop()

def main():
    parser = argparse.ArgumentParser(description="MoltBot")
    parser.add_argument("-d", "--direct", action="store_true", help="Run direct questions bot")
    parser.add_argument("-u", "--upload", action="store_true", help="Run upload questions bot")
    parser.add_argument("-r", "--remove", action="store_true", help="Run remove questions bot")

    args = parser.parse_args()

    if args.direct:
        bot = MoltBot()
        bot.run_bot()
    elif args.upload:
        # Run upload bot
        pass
    elif args.remove:
        # Run remove bot
        pass

if __name__ == "__main__":
    main()

### System Commands

The bot has three system commands:

* `/renew`: Renew the syllabus by updating the question history.
* `/upload_one_more`: Upload one more question to bypass the upload limit.
* `/removejustuploadedcode`: Remove the most recently uploaded code to killswitch the bot.

### Syllabus Kaise Upload Karein (Step-by-Step)

To upload the syllabus, follow these steps:

1. Send a message to the bot with the command `/renew`.
2. Respond with `YES`.
3. Send or paste the new syllabus text to the bot.
4. The bot will parse the text and create a question history.

### PC par Turant Bot Start/Kill Karne ke Liye Desktop ke Start_Moltbot.bat ya Stop_Moltbot.bat Buttons Use Karein.

To start or stop the bot, use the `Start_Moltbot.bat` or `Stop_Moltbot.bat` buttons on your desktop.

### Rules

1. Provide ONLY raw code.
2. NO explanations, NO markdown wrappers.

### Token Settings:

The bot requires a GitHub API token. To set the token, replace `YOUR_GITHUB_TOKEN` with your actual token.

### History Settings:

To set the syllabus history, create a directory called `histories` in the same directory as the bot script. Each day, the bot will create a new file with the date in the format `YYYY-MM-DD` and store the question history in that file.