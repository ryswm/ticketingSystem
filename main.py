#!/usr/bin/env python3  #Setting interpreter
import numpy as np
from decimal import *

#TODO: EVENT FILE

#This method takes in a username designated by the user and writes it to the AccountFile.text
def createUser():
    global users
    global dailyTransactions

    code = "01 "
    defaultcredit = "000000.00"
    userAdded = False

    newUser = input("Please enter your desired username: \n")
    if len(newUser) > 15:
        print("Username cannot exceed 15 characters.")
    elif newUser in users:
        print("Sorry, this username is already taken.")
    elif newUser not in users:
        atype = input("Please enter the account type for this user: \n")
        if(atype == "AA"):
            atype = "AA"
            print("Successfully created the user, " + newUser)
            new = np.array([[newUser,atype,defaultcredit]])
            users = np.concatenate((new,users),axis=0)
            userAdded = True
        elif(atype == "FS"):
            type = "FS"
            print("Successfully created the user, " + newUser)
            new = np.array([[newUser,atype,defaultcredit]])
            users = np.concatenate((new,users),axis=0)
            userAdded = True
        elif(atype == "BS"):
            type = "BS"
            print("Successfully created the user, " + newUser)
            new = np.array([[newUser,atype,defaultcredit]])
            users = np.concatenate((new,users),axis=0)
            userAdded = True
        elif(atype == "SS"):
            type = "SS"
            print("Successfully created the user, " + newUser)
            new = np.array([[newUser,atype,defaultcredit]])
            users = np.concatenate((new,users),axis=0)
            userAdded = True
        else:
            print("Sorry that is not a valid option, user creation cancelled")
        
        if userAdded:   #If successfully added, add transaction to daily transaction list
            transaction = str(code + newUser + " " + atype + " " + defaultcredit)
            dailyTransactions = np.append(dailyTransactions,transaction)
            userAdded = False


#This method verifies the users login credentials
def login():    
    global currentLogin
    global users
    currentUser = input('Please enter your username to login \n') #Prompt for user to input username *need to add error handling*
  
    if currentLogin == True:
        print("A user is already logged in, logout before next login")
    elif len(currentUser) > 15:
        print("Username cannot exceed 15 characters.")
    elif currentUser in users:
        print("Successfully logged in as: " + currentUser)
        currentLogin = True
    elif currentUser not in users:
        print("User does not exist in the system.")

def logout():
    code = "00"
    global currentLogin
    if currentLogin == True:
        currentLogin = False
    print("You have successfully logged out")
    f = open("Transactions.txt", "r")
    transactions = f.readlines()
    print(transactions)
    #TODO: End frontend session
    #TODO: Have backend process all sessions transactions
    #TODO: Read in new account file and event file in preperation for next login

    
#This method deletes users from the system
def delete():
    global users
    global dailyTransactions
    code = "02 "

    deleteUser = input("Enter the username to delete: \n(Warning, deleted accounts cannot be recovered)\n")
    if deleteUser in users:                     #If selected user is real account
        for i in range(len(users) - 1):           
            if users[i,0] == deleteUser:

                users = np.delete(users, i, 0) #Delete user from users array

                credit = float(users[i,2]) #Format users credit for transaction line
                credit = '{:0>9}'.format(str("{:.2f}".format(credit)))

                transaction = str(code + deleteUser.ljust(15) + " " + users[i,1] + " " + credit) #Add transaction to daily transactions list
                dailyTransactions = np.append(dailyTransactions,transaction)
        print("Successfully deleted the user," + deleteUser + " \n -------------------------------")
    elif deleteUser not in users:               #If selected user is not real account
        print("User does not exist in the system.") 


def addCredit():
    code = "06 "
    global users
    global dailyTransactions

    user = input("Enter the name of user to add credit to: \n")
    if user in users: #Check if selected user is a real account
        amount = int(input("Enter the amount of credit to add: \n"))

        #TODO: Add check against previous addcredit this session

        if amount <= 1000: #Check if desired credit ammount is within daily add limit
            for i in range(len(users[:,:])): #Iterate through usernames
                if users[i,0] == user: 
                    userCredit = float(users[i,2]) #Credit stored as string, must convert to manipulate
                    userCredit += amount
                    users[i,2] = str("{:.2f}".format(userCredit))   #Format and reassign to users array
                    print("Credit added to " + user)

                    transaction = str(code + user.ljust(15) + " " + users[i,1] + " " + '{:0>9}'.format(users[i,2]))
                    dailyTransactions = np.append(dailyTransactions, transaction)
                    
def refund():
    code = "05 "
    global users
    global dailyTransactions
    buyer = input("Please enter buyer's account name. \n")
    if buyer in users:
        for i in range(len(users) - 1):
            if users[i,0] == buyer:
                buyerCredit = float(users[i,2])
                refund = int(input("Please enter refund amount. \n"))
                if(refund <= 999999):
            #TODO: Check that adding the refund to account doesn't exceed credit limit 999999
                    seller = input("Please enter seller's account name. \n")
            #TODO: fix subtraction bounds error
                    if seller in users:
                        for i in range(len(users) - 1):
                            if users[i,0] == seller:
                                credit = (str("{:.2f}".format(refund)))
                                buyerCredit += refund
                                users[i, 2] = str("{:.2f}".format(buyerCredit))
                                print(buyer + " has been refunded")
                                print(buyer + " now has " + users[i, 2] + " in their account")

                                sellerCredit = float(users[i,2])
                                sellerCredit -= refund
                                users[i, 2] = str("{:.2f}".format(sellerCredit))
                                print(seller + " has been debited")
                                print(seller + " now has " + users[i, 2] + " in their account")

                                transaction = str(code + buyer.ljust(15) + seller.ljust(15) + '{:0>9}'.format(credit))
                                print(transaction)
                                dailyTransactions = np.append(dailyTransactions, transaction)

                            else:
                                print("Refund exceeds the maximum amount")
                    else:
                        print("Seller does not exist!")
                else:
                    print("Refund exceeds the maximum amount")
    else:
        print("Buyer does not exist!")

#Triggers the main menu UI which displays the user options
def mainMenu():
    print("Welcome to the Tix ticketing system, please enter one of the following options.")
    selection = input(" 1. create \n 2. login \n 3. logout \n 4. delete \n 5. sell \n 6. buy \n 7. refund \n 8. addcredit \n 9. quit\n")
    if selection == "create":
        createUser()
    elif selection == "login":
        login()
    elif selection == "logout":
        logout()
    elif selection == "delete":
        delete()
    elif selection == "addcredit":
        addCredit()
    elif selection == "refund":
        refund()
    elif selection == "quit":
       global run
       run = False
    elif selection == "r":
        print(users)
        print(events)
        print(dailyTransactions)
    else:
        print("\nSorry but that is not a valid option\n")
    #TODO: Add the rest of the options once the functions are made

def readAccounts(): 
    file = open("AccountFile.txt","r")
    lines = file.readlines()
    file.close()
    global users

    for i in range(len(lines)):
        line = lines[i]
        username = line[0:15].rstrip(" ")
        status = line[16:18]
        credit = line[19:28].lstrip("0")
        user = [username, status, credit]
        users.append(user)


def readEvents():
    file = open("eventFile.txt", "r")
    lines = file.readlines()
    file.close()

    global events
    for i in range(len(lines)):
        line = lines[i]
        title = line[0:18].rstrip(" ")
        seller = line[19:34].rstrip(" ")
        amount = line[35:38].lstrip("0")
        price = line[39:45].lstrip("0")
        event = [title, seller, amount, price]
        events.append(event)

def writeEvents():
    global dailyTransactions
    endLine = str("00 " + )
    f = open("eventFile.txt", "w")
    for i in range(len(dailyTransactions) - 1):
        f.write(dailyTransactions[i] + "\n")
    f.write()
    f.close()






#Initial start welcome & prompt for username

#Global variables
run = True
currentLogin = False
newUsers = []
dailyTransactions = []
users = []
events = []

readAccounts()  #Read in account file at start
users = np.asarray(users)

readEvents()
events = np.asarray(events)

while run:  #   Main program loop
    mainMenu()

