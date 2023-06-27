import pyrebase
import time
import datetime
def senddata(a):
    config={
        "apiKey": "AIzaSyC9cZtBXctNqwSaQqgIUywF-l42bE7iV0I",
        "authDomain": "securityapp-95753.firebaseapp.com",
        "databaseURL": "https://securityapp-95753-default-rtdb.firebaseio.com/",
        "projectId": "securityapp-95753",
        "storageBucket": "securityapp-95753.appspot.com",
        "messagingSenderId": "219116190289",
        "appId": "1:219116190289:web:79d2a38ed025dde38ad670",
        "measurementId": "G-GSQVVMTFB9"
        }
    firebase= pyrebase.initialize_app(config)
    database=firebase.database()
    data={"message":str(a)}
    database.set(data)
def workingday(time):
    time=str(time).replace(":","")
    time=int(time)
    if((time>=930 and time<=1200)or(time>=1500 and time<=1730)):
        a="safe"
    else:
        a="not safe"
    return a

def mains(times,day,person):
    if "Monday" in day or "Tuesday" in day or "Wednesday" in day or "Thursday" in day or "Friday" in day or "Saturday":
        s=workingday(times)
      
    else:
        s="not safe"
    if s=="safe":
        print("")
    else:
        if str(person)=="Who are you ?":
            person="Unknown Person Found"
            senddata("Suspisous"+" "+str(times)+" "+str(person))
        senddata(str(person)+" "+str(times))
        
        #time.sleep(10)
