/*
-------------------------------------------------------------------------------------------------------------
EserviceforgetPassword.js
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author -
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
*/
var MSG_NORMAL = 0;
var MSG_ERROR = 1;
var MSG_LOADING = 'Loading ...';

function onLoad(){
    var errorMsg = document.getElementById("errMsg");
    if(!isNullObj(errorMsg) && !isBlank(errorMsg.value)){
        showBarMessage(errorMsg.value, MSG_ERROR);
        errorMsg.value = '';
    }
    
    noBack();
}

function submitBtn(){
    var url = FORGET_PASSWORD;
    try{
        if(validation()){
            loading();
            
            document.forms[0].action = url;
            document.forms[0].submit();
        }
    }catch(err){
        handleJavaScriptError('submitBtn', err.message, 0);
    }
}

function clearBtn(){
    var txtEmailAddress = document.getElementsByName('emailAddress')[0];
    var txtUserId = document.getElementsByName('userId')[0];
    try{
        txtEmailAddress.value = '';
        txtUserId.value = '';
    }catch(err){
        handleJavaScriptError('clearBtn', err.message, 0);
    }
}

function validation(){
    var txtUserId = document.getElementsByName('userId')[0];
    var txtEmailAddress = document.getElementsByName('emailAddress')[0];
    var isPass = true;
    try{
        if(isNullObj(txtUserId) || isBlank(txtUserId.value)){
            showBarMessage('Please specify the User ID.', MSG_ERROR);
            txtUserId.focus();
            
            isPass = false;
        }
        if(isPass && !validateEmail(txtEmailAddress)){
            isPass = false;
        }
    }catch(err){
        handleJavaScriptError('validation', err.message, 0);
        isPass = false;
    }
    return isPass;
}
function validateEmail(emailObj){
    var emailPass = false;
    var emailEmpty = false;
    var isPass = true;
    try{
       if(isNullObj(emailObj) || isBlank(emailObj.value)){
            showBarMessage('Please specify the email address.', MSG_ERROR);
            emailObj.focus();
        
            isPass = false;
        }else{
            emailPass = validEmailFormat(emailObj);
            if(!emailPass){
                 showBarMessage('Please provide a valid email address.', MSG_ERROR);
                 emailObj.focus();
                 
                 isPass = false;
            }
        }
    }catch(err){
        handleJavaScriptError('validateEmail', err.message, 0);
        isPass = false;
    }
    return isPass;
}

function validEmailFormat(emailObj){
    var emailFormat = /^.+@.+\..{2,3}$/;
    var emailFormat2 = /^.+@.+\..{2,3}\..{2,3}$/;
    
    var isPass = false;
    if(emailFormat.test(emailObj.value)){
        isPass = true;
    }else if(emailFormat2.test(emailObj.value)){
        isPass = true;
    }
    return isPass;	
}

function validEmailKey(e, emailObj){
    var additionSign = '@';
    var keyFormat = /[A-Za-z0-9_-]/g;
    var charVal = null;
    var emailMatchingResult = null;
    var isPass = false;
    try{
        charVal = String.fromCharCode(e.keyCode);
        if(charVal == additionSign){
            emailMatchingResult = emailObj.value.match(charVal);
            
            if(emailMatchingResult != additionSign){
                isPass = true;
            }	
        }else{
            if(keyFormat.test(charVal) || charVal == '.'){
                isPass = true;
            }
        }
    }catch(err){
        handleJavaScriptError('validEmailKey', err.message, 0);
        isPass = false;
    }
    return isPass;
}

function homeClicked(){
    window.close();
    
    var messageTdParent = parent.opener.document.getElementById("msg");
    messageTdParent.innerHTML = MSG_LOADING;
    
    parent.opener.location.href = 'http://www.rclgroup.com';
}

function backHome(){
    loading();
    
    window.location = 'http://www.rclgroup.com';
}

function loading(){
    showBarMessage(MSG_LOADING, 0);
    
    pausePage1();
}

function clearMsg(){
    showBarMessage('Ready', MSG_NORMAL);
}

function noBack() { 
    window.history.forward(); 
}
