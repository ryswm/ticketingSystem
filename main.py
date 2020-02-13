#!/usr/bin/env python3  #Setting interpreter

#TODO: READ ACCOUNT FILE & EVENT FILE
#using content manager
with open('AccountFile', 'r') as f:
    f_contents = f.readline()
    print(f_contents, end='')
    f_contents = f.readline()
    print(f_contents,)

#TODO: LOGIN AS currentUser
def login():
    f = open("users.txt", "r")
    users = f.read()
    currentUser = input('Please enter your username to login \n') #Prompt for user to input username *need to add error handling*
    #TODO: USER INPUT ERROR CHECKING
    #TODO: Read username against accountfile
    #Username cannot exceed 15 characters
    if len(currentUser) > 15:
        print("Username cannot exceed 15 characters.")
    elif currentUser in users:
        print("Successfully logged in as: " + currentUser)
    elif currentUser not in users:
        print("User does not exist in the system.")
#Initial start welcome & prompt for username
print('Hello, Welcome to Tix ticketing system.')
login()



#TODO: PROVIDE UI MENU FOR AVAILABLE USER FUNCTIONS
