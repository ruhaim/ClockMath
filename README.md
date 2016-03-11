# ClockMath


Provides methods to calculate the angle between the hands of an analog clock when a time is input

-*The angle between the hour and minute hand assuming that the hour hand does not move at all until it need to shift to the next hour*

-*The angle between the hour and minute hand assuming that the hour hand moves in proportion to the minutes within an hour*

-*The angle between a minute hand and a second hand of an analog watch; assuming the minute hand moves proportional to the seconds expended*


**Input**

Accepts no command line params
But will prompt the user to enter `time` in 24hr clock format (HHMM)

    Please input a time (HHMM):

The time is validated, if invalid will keep prompting the user to input a valid input;


**Output**
For example for time : 2345
The following is output 

    SIMPLE - Angle made by the hour and minute hands (degrees) : 60.0
    REAL - Angle made by the hour and minute hands (degrees) : 82.5

**Analysis**

-There are validations in place to reject invalid input from the user

-Regex used for format validation

-User friendly errors are displayed

-The code is modularized, so that the methods could be used with no dependency

    getAngleSimple(int _hr, int _min)
    getAngleReal(int _hr, int _min)
    getAngleRealMinSec(int _min, int _sec)

-There are a few test cases defined in the `runTests()` method
