
#Update account file for create function
if userAdded:   #If successfully added, change accounts file
    with open("AccountFile.txt", "r") as f:     #Read accounts file to store lines
        lines = f.readlines()
        f.close()
    with open("AccountFile.txt", "w") as f:     #Write lines with changes to file
        f.write(newUser.ljust(15) +  " " + atype + " " + defaultcredit + "\n")
        for line in lines:
            f.write(line) 
    f.close()
    userAdded = False



#Update account file for delete function
with open("AccountFile.txt", "r") as f: #Get lines from accounts file
    lines = f.readlines()
    f.close()
with open("AccountFile.txt", "w") as f: #Write all users that are not selected user; Deleting user from account file
    for line in lines: 
        if line[0:len(deleteUser)] != deleteUser: 
            f.write(line)



#Update account file for addcredit function
with open("AccountFile.txt", "r") as f:     #Read accounts file to store lines
    lines = f.readlines()
    f.close()
with open("AccountFile.txt", "w") as f:     #Write lines with changes to file
    for line in lines:
        if line[0:len(user)] != user:   #Write unchanged lines
            f.write(line) 
        else:                       #Write changed line
            c = '{:0>9}'.format(str("{:.2f}".format(userCredit)))
            f.write(str((line[0:19])) + c + "\n")
f.close()