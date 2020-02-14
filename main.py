#!/usr/bin/env python3  #Setting interpreter

#TODO: READ ACCOUNT FILE & EVENT FILE
#TODO: Change account system by adding types of users instead of just usernames
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

def delete():
    f = open("AccountFile.txt", "r+")
    users = f.read()
    deleteUser = input("Enter the username to delete: \n(Warning, deleted accounts cannot be recovered)\n")
    if deleteUser in users:
        with open("AccountFile.txt", "r") as f:
            lines = f.readlines()
        with open("AccountFile.txt", "w") as f:
            for line in lines:
                if line.strip("\n") != deleteUser:
                    f.write(line)   
        print("Successfully deleted the user," + deleteUser + " \n -------------------------------")
        mainMenu()
    elif deleteUser not in users:
        print("User does not exist in the system.")
def mainMenu():
    print("Welcome to the Tix ticketing system, please select from the following options.")
    selection = input("1. create \n 2. login \n 3. logout \n 4. delete \n 5. sell \n 6. buy \n 7. refund \n 8. addcredit \n")
    if selection == "create":
        createUser()
    elif selection == "login":
        login()
    elif selection == "delete":
        delete()
    #TODO: Add the rest of the options once the functions are made
#Initial start welcome & prompt for username
mainMenu()

