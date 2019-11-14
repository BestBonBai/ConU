/******************************************************************
 * PHOTO RESISTOR
 * 
 * Use a photoresistor (light sensor) to control the brightness
 * of a LED.
 * 
 * A part of this program was written by SparkFun Electronics. 
 * with modification by Duc Nguyen for the project.
 *
 * Visit http://learn.sparkfun.com/products/2 for SIK information.
 * Visit http://www.arduino.cc to learn about the Arduino.
 * 
 * Version 2.0 6/2012 MDG
 * Version 2.1 9/2014 BCH
/*****************************************************************/

const int sensorPin = 0;
const int ledPin = 9;

int lightLevel;
int calibratedlightLevel; 
int maxThreshold = 1023; 
int minThreshold = 0;   

void setup()
{
  pinMode(ledPin, OUTPUT);    
  Serial.begin(9600);
}

void loop()
{
  lightLevel = analogRead(sensorPin);  
  Serial.print(lightLevel);
  autoRange();  // autoRanges the min / max values you see in your room.

  calibratedlightLevel = map(lightLevel, 0, 1023, 0, 255);  // scale the lightLevel from 0 - 1023 range to 0 - 255 range.
  Serial.print("\t"); 		  
  Serial.print(calibratedlightLevel);   

  analogWrite(ledPin, calibratedlightLevel);    // set the led level based on the input lightLevel.
}
/******************************************************************
 * void autoRange()
 * 
 * This function sets a minThreshold and maxThreshold value for the
 * light levels in your setting. Move your hand / light source / etc
 * so that your light sensor sees a full range of values. This will
 * "autoCalibrate" to your range of input values.
/*****************************************************************/

void autoRange()
{
  if (lightLevel > minThreshold)  
    minThreshold = lightLevel;

  if (lightLevel < maxThreshold)  
    maxThreshold = lightLevel;

  // Once we have the highest and lowest values, we can stick them
  // directly into the map() function.
  // 
  // This function must run a few times to get a good range of bright and dark values in order to work.

  lightLevel = map(lightLevel, minThreshold, maxThreshold, 0, 255);
  lightLevel = constrain(lightLevel, 0, 255);
}
