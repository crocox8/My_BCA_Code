# Assignment Question:
# Design an IoT system using ESP8266 to monitor and control a greenhouse environment, incorporating the following features:
- Read temperature and humidity levels using a DHT11 sensor.
- Display current values on an LCD display.
- Use a servo motor to adjust the angle of a solar panel based on the temperature.
- Implement a WiFi-based notification system to alert the user when the temperature exceeds a set threshold.
- Allow users to send remote commands via a mobile app to adjust the temperature or humidity settings.
# Author: Ansh Pandey

Hardware Requirements:

- ESP8266 WiSoBoard
- DHT11 sensor
- 16x2 LCD display
- Servo motor
- Power supply
- Breadboard
- Jumper wires

Software Requirements:

- Arduino IDE
- Wi-Fi Library (ESP8266WiFi)
- WiFiManager Library (WiFiManager)
- PubSubClient Library (PubSubClient)

Code:
#include <WiFi.h>
#include <DHT.h>
#include <LiquidCrystal_I2C.h>
#include <Servo.h>
#include <WiFiManager.h>
#include <PubSubClient.h>

#define DHTPIN 4
#define DHTTYPE DHT11
#define LCD_SCK 14
#define LCD_SDA 12
#define SERVOMOTORPIN 13
#define PUBLISH_TOPIC "greenhouse"

const char* ssid = "YourSSID";
const char* password = "YourPassword";
const char* broker = "YourBroker";
const char* clientID = "YourClientID";

WiFiClient espClient;
PubSubClient client(espClient);
DHT dht(DHTPIN, DHTTYPE);
LiquidCrystal_I2C lcd(LCD_SCK, LCD_SDA);
Servo servo;

void setup() {
  Serial.begin(115200);
  lcd.begin(16, 2);
  servo.attach(SERVOMOTORPIN, 500);
  WiFiManager wifiManager;
  wifiManager.setAPStaticIPConfig(WiFiConfig);
  wifiManager.autoConnect("Greenhouse_AP");

  lcd.print("Wi-Fi connected");
  lcd.setCursor(0, 1);
  lcd.print(WiFi.SSID());

  // Connect to MQTT
  client.setServer(broker);
  if (!client.connected()) {
    reconnect();
  }
}

void loop() {
  dht.readTempAndHum();
  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();

  lcd.setCursor(0, 0);
  lcd.print("Temp: ");
  lcd.print(temperature);
  lcd.print("C");
  lcd.setCursor(0, 1);
  lcd.print("Hum: ");
  lcd.print(humidity);
  lcd.print("%");

  if (temperature > 30) {
    servo.write(90);
  } else {
    servo.write(0);
  }

  if (millis() % 10000 < 1000) {
    // Publish data
    char buffer[30];
    sprintf(buffer, "{temperature: %f, humidity: %f}", temperature, humidity);
    client.publish(PUBLISH_TOPIC, buffer);
  }

  client.loop();
  delay(1000);
}

void reconnect() {
  while (!client.connected()) {
    Serial.print("Reconnecting... ");
    client.connect(clientID, "username", "password");
    Serial.println("reconnected");
  }
}

const WiFiConfig wifiConfig(192, 168, 4, 1);
Remote Command Handler (ESP8266):
#include <WiFi.h>
#include <WiFiManager.h>

const char* ssid = "YourSSID";
const char* password = "YourPassword";

WiFiManager wifiManager;

void setup() {
  Serial.begin(115200);
  wifiManager.setAPStaticIPConfig(WiFiConfig);
  wifiManager.autoConnect("Greenhouse_AP");
}

void loop() {
  if (Serial.available() > 0) {
    String command = Serial.readStringUntil('\r');
    if (command.startsWith("temperature=")) {
      int temp = command.substring(10).toInt();
      client.publish("remote/command", String(temp));
    } else if (command.startsWith("humidity=")) {
      int humidity = command.substring(8).toInt();
      client.publish("remote/command", String(humidity));
    }
  }
}
Note: Replace the `ssid`, `password`, `broker`, `clientID` with your actual network credentials. Also, the code assumes that you have a basic knowledge of the libraries used and how to set up the hardware.