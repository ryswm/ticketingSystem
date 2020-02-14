#!/usr/bin/env python3  #Setting interpreter

#TODO: READ ACCOUNT FILE & EVENT FILE

#This method takes in a username designated by the user and writes it to the AccountFile.text
def createUser():
    f = open("AccountFile.txt","a+")
    users = f.read()
    newUser = input("Please enter your desired username: \n")

    if len(newUser) > 15:
        print("Username cannot exceed 15 characters.")
    elif newUser in users:
        print("Sorry, this username is already taken.")
    elif newUser not in users:
        print("Successfully created the user, " + newUser)
        f.write(newUser)

#This method verifies the users login credentials
def login():
    f = open("AccountFile.txt", "r")
    users = f.read()
    currentUser = input('Please enter your username to login \n') #Prompt for user to input username *need to add error handling*
    #TODO: USER INPUT ERROR CHECKING
    #TODO: Read username against accountfile
    #Username cannot exceed 15 characters
    if len(currentUser) > 15:
        print("Username cannot exceed 15 characters.")
    elif currentUser in users:
        print("Successfully logged in as: " + currentUser)
        mainMenu()
    elif currentUser not in users:
        print("User does not exist in the system.")

#This method triggers the main menu and gives the user the option to create an account or login
def mainMenu():
    print("Welcome to the Tix ticketing system, please select from the following options.")
    selection = input("1. create \n 2. login \n 3. logout \n 4. delete \n 5. sell \n 6. buy \n 7. refund \n 8. addcredit \n")
    if selection == "create":
        createUser()
    elif selection == "login":
        login()
    #TODO: Add the rest of the options once the functions are made
#Initial start welcome & prompt for username
mainMenu()



#TODO: PROVIDE UI MENU FOR AVAILABLE USER FUNCTIONS
