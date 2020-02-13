#!/usr/bin/env python3  #Setting interpreter

#TODO: READ ACCOUNT FILE & EVENT FILE
#using content manager
with open('AccountFile', 'r') as f:
    f_contents = f.readline()
    print(f_contents, end='')
    f_contents = f.readline()
    print(f_contents,)

#Initial start welcome & prompt for username
print('Hello, Welcome to Tix ticketing system.')

currentUser = input('Please enter your username to login \n'); #Prompt for user to input username *need to add error handling*
#TODO: USER INPUT ERROR CHECKING
#TODO: Read username against accountfile
#Username cannot exceed 15 characters
if len(currentUser) > 15:
    print("too big")

#TODO: LOGIN AS currentUser

#TODO: PROVIDE UI MENU FOR AVAILABLE USER FUNCTIONS
