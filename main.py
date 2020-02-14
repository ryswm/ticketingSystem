#!/usr/bin/env python3  #Setting interpreter

#TODO: READ ACCOUNT FILE & EVENT FILE

#This method takes in a username designated by the user and writes it to the AccountFile.text
def createUser():
    global newUsers
    f = open("AccountFile.txt","a+")
    users = f.read()
    f.close()
    newUser = input("Please enter your desired username: \n")

    if len(newUser) > 15:
        print("Username cannot exceed 15 characters.")
    elif newUser in users:
        print("Sorry, this username is already taken.")
    elif newUser not in users:
        print("Successfully created the user, " + newUser)
        newUsers.append(newUser)
        print(newUsers)
        

#This method verifies the users login credentials
def login():
    global currentLogin
    f = open("AccountFile.txt", "r")
    users = f.read()
    f.close()
    currentUser = input('Please enter your username to login \n') #Prompt for user to input username *need to add error handling*
    #TODO: USER INPUT ERROR CHECKING
    #TODO: Read username against accountfile
    #Username cannot exceed 15 characters
    if currentLogin == True:
        print("A user is already logged in, logout before next login")
    elif len(currentUser) > 15:
        print("Username cannot exceed 15 characters.")
    elif currentUser in users:
        print("Successfully logged in as: " + currentUser)
        currentLogin = True
        #mainMenu()
    elif currentUser not in users:
        print("User does not exist in the system.")
    
#This method deletes users from the system
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

#This method triggers the main menu and gives the user the option to create an account or login
def mainMenu():
    print("Welcome to the Tix ticketing system, please select from the following options.")
    selection = input(" 1. create \n 2. login \n 3. logout \n 4. delete \n 5. sell \n 6. buy \n 7. refund \n 8. addcredit \n 9. quit\n")
    if selection == "create":
        createUser()
    elif selection == "login":
        login()
    elif selection == "delete":
        delete()
    elif selection == "quit":
       global run
       run = False
    elif selection == "r":
        readAccounts()
    else:
        print("\nSorry but that is not a valid option\n")
    #TODO: Add the rest of the options once the functions are made

def readAccounts(): 
    file = open("AccountFile.txt","r")
    lines = file.readlines()
    file.close()
    users = []
    for i in range(len(lines)):
        line = lines[i]
        username = line[0:14].rstrip(" ")
        status = line[16:17]
        credit = line[19:].lstrip("0")
        user = [username, status, credit]
        users.append(user)

#Initial start welcome & prompt for username
#   Main program loop
run = True
currentLogin = False
newUsers = []
while run:
    mainMenu()



#TODO: PROVIDE UI MENU FOR AVAILABLE USER FUNCTIONS
