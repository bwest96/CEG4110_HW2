# CEG4110_HW2 Brian West
git repo: https://github.com/bwest96/CEG4110_HW1.git
## Screen Shots
<img src="https://github.com/bwest96/CEG4110_HW2/blob/master/Screenshots/SmartSelect_20181011-075821_My%20Application.jpg" align="left" width="250" height= "500" hspace="10" vspace="10"></a>
<img src="https://github.com/bwest96/CEG4110_HW2/blob/master/Screenshots/SmartSelect_20181011-075859_My%20Application.jpg" align="left" width="250" height= "500" hspace="10" vspace="10"></a>


## Usage
To install and run app execute app-release.apk located in the bin directory.

The app shows the time and date in digital format by deafualt then you can add more digital views or analog views. The date and time can be changed and can undo and redo time changes.
 

## Design
<img src="https://github.com/bwest96/CEG4110_HW2/blob/master/Screenshots/diagram.png" align="left" width="250" height= "500" hspace="10" vspace="10"></a>
The design has a time model that has date variable and date change variable which offset date to date change from current time when time is gotten from controller. It also has a getter and setter for date to get date and set date change.

The controller has a time variable date getter and setter to get and set time. It also passes the date change to the command queue.

The view has two view types analog and digital. The analog view I used https://github.com/TurkiTAK/vector-analog-clock to make the clock. When the tab is changed to analog view the clock time is set to the currently set time gotten from the controller. When the tab is set to a digital view it uses a thread to update to time from the controller every second.

The command queue stores the date change which is the offset from the current time which allows the times stored to continue increase in time because it is an offset of the current time. There is also an isempty function so the controller can tell if the stacks are empty.
