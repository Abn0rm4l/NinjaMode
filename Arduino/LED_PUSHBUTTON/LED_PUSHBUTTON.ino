const int LED = 13;    // the pin for LED
const int BUTTON = 7;   // the input ping where there
                       // pushbutton is connected
int val = 0;           // Val will be used to store the state
                       // of the input pin
                       
void setup(){
  pinMode(LED, OUTPUT);    // tell Arduino LED is an output
  pinMode(BUTTON, INPUT);  // and BUTTON is an input
}

void loop(){
  val = digitalRead(BUTTON);  // read input value and store it
  
  // Check whether the input is HIGH (button pressed)
  if (val == HIGH){
    digitalWrite(LED, HIGH);  // turn LED ON
  } else {
    digitalWrite(LED, LOW);  // turn LED OFF
  }
}
