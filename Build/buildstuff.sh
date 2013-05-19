#!/bin/bash
FAILED = 0
email_subject = ""
echo "\n build started: Displaying the current PATH variable \n" + $PATH
echo "\n Current working directory `pwd` value of my home \n" + $GUGI_HOME
echo "\n listing the files in present directory \n `ls -al`"
echo "\n changing the permission for $ANDROID_HOME \n"

sudo chmod 777 -R ./android-sdk-linux/
android update sdk   --filter 1,2,3,4 --no-ui --force
android list targets
android update project --name mpetition --target 1  --path ${GUGI_HOME}/MPetition-app/ 
cd $GUGI_HOME/MPetition-app

echo "\n Starting the ant to build \n"
$email_subject = `ant -f build.xml`  
$email_subject =  `$email_message ant clean`  
$email_subject = `$email_message ant debug`  
if [ "$?" = 1 ]; then
    echo "\n Application failed! \n"
    FAILED=1
fi
# Send the email to all project participants only if build succeds
if [$FAILED = 0]; then
   xemails="expie00101@gmail.com,expie00102@gmail.com"
   mail -s "$email_subject" $xmails
fi  		
exit $FAILED
