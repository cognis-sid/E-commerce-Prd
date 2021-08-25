var SORT_TYPE_ID = '1';
var SORT_TYPE_SUBJECT = '2';
var SORT_TYPE_DATE = '3';
var IMG_SORT_ASC = '../images/mres/mres_sort_asc.gif';
var IMG_SORT_DESC = '../images/mres/mres_sort_desc.gif';

var error_code = 0;

function onLoad(){
    var sortCol = document.getElementsByName('sortCol');
    var orderBy = document.getElementsByName('orderBy');
    
    var idSortImg = null;
    var subjectSortImg = null;
    var dateSortImg = null;
    var imgPath = null;
    try{
//        alert('OrderBy = '+orderBy[0].value);
        if(orderBy[0].value == 'DESC'){
            imgPath = IMG_SORT_DESC;
        }else{
            imgPath = IMG_SORT_ASC;
        }
//        alert('sortCol.value = '+sortCol.value);
        if(SORT_TYPE_ID == sortCol[0].value){    
//            alert('SORT_TYPE_ID: idSortImg');
            sortImgControl('idSortImg', imgPath); 
//            alert('SORT_TYPE_ID: subjectSortImg');
            sortImgControl('subjectSortImg', null); 
//            alert('SORT_TYPE_ID: dateSortImg');
            sortImgControl('dateSortImg', null); 
        }else if(SORT_TYPE_SUBJECT == sortCol[0].value){   
//            alert('SORT_TYPE_SUBJECT: idSortImg');      
            sortImgControl('idSortImg', null); 
//            alert('SORT_TYPE_SUBJECT: subjectSortImg');   
            sortImgControl('subjectSortImg', imgPath);
//            alert('SORT_TYPE_SUBJECT: dateSortImg');   
            sortImgControl('dateSortImg', null);
        }else if(SORT_TYPE_DATE == sortCol[0].value){         
//            alert('SORT_TYPE_DATE: idSortImg');  
            sortImgControl('idSortImg', null);        
//            alert('SORT_TYPE_DATE: subjectSortImg');  
            sortImgControl('subjectSortImg', null);       
//            alert('SORT_TYPE_DATE: dateSortImg');  
            sortImgControl('dateSortImg', imgPath);
        }
        noBack();
    }catch(err){
        handleJavaScriptError('onload', err, 0);
    }
}

function sortImgControl(imgName, imgPath){
    var sortImg = document.getElementById(imgName);
    try{
        if(!isNullObj(sortImg)){
            if(isNullObj(imgPath) || '' == imgPath){
                imgPath = IMG_SORT_ASC;
            }else{
//                alert('imgName = '+imgName+': imgPath = '+imgPath);
            }
            sortImg.src = imgPath;
        }
    }catch(err){
        handleJavaScriptError('sortImgControl', err, 0);
    }
}

function backHome(){
    loading();
    
    window.location = 'http://www.rclgroup.com';
}


function noBack() { 
    window.history.forward(); 
}

function logout(){
    if(confirm('Are you sure to log out?')){
        loading();
    
        document.forms[0].action = getLogOutUrl();
        document.forms[0].submit();
    }
}

function homeClicked(){
    loading();
    
    window.close();
    
    var messageTdParent = parent.opener.document.getElementById("msg");
    messageTdParent.innerHTML = MSG_LOADING;
    
    parent.opener.location.href = 'http://www.rclgroup.com';
}

function openScreenForMRES(screen_url,screen_id){
    var screenWidth = aw-5;
    var screenHeight= ah-54;
    var x = aw>800?(aw-screenWidth)/2:0;
    var y = ah>600?(ah-screenHeight)/2:0;
    var winName = screen_id;
    var lo_usrLogin = document.getElementById("usrLogin");
    
    
//    alert(screen_url + lo_usrLogin.value);return;
//    if(confirm('Please ensure your browser is running on compatability mode ("Download instruction from eService Setup").Also this application work best in IE version8. Continue?')){
        childWindow = window.open(screen_url + lo_usrLogin.value,winName, 'width='+screenWidth+',height=' + screenHeight+40 + ',left=' + x + ',top=' + y + 'resizable=yes,scrollbars=yes,toolbar=yes,titlebar=yes');
        childWindow.focus();
//    }
}

function manageAccount(){
	debugger;
    var url = MANAGE_ACCOUNT;
    try{
        error_code = 1;
//        if(confirm('Please ensure your browser is running on compatability mode ("Download instruction from eService Setup").Also this application work best in IE version8. Continue?')){
            openScreen(url,'serv007');
//        }
        error_code = 2;
    }catch(err){
        handleJavaScriptError('manageAccount', err, error_code);
    }
}

function loadMailBody(mailObj, mailBodyIndex) {
    var mailSubjectHid = document.getElementsByName('mailSubjectHid');
    mailObj.title = mailSubjectHid[mailBodyIndex].value;
}

function clickNotificationSorting(sortType, orderBy){
    var sortColObj = document.getElementsByName('sortCol');
    var orderByObj = document.getElementsByName('orderBy');
    var currPageNo = document.getElementsByName('currPageNo');
    var lstrUrl = getActionUrl();
    try{
        loading();
            
        sortColObj[0].value = sortType;
        orderByObj[0].value = orderBy;
//        alert('sortCol = '+sortColObj[0].value+'\norderBy = '+ orderByObj[0].value+'\nURL = '+lstrUrl);
        if(!isNullObj(lstrUrl) && '' != lstrUrl) {
//            currPageNo[0].value = '1';
            document.forms[0].action = lstrUrl ;
            document.forms[0].submit();
    }
    }catch(err){
        handleJavaScriptError('clickNotificationSorting', err, 0);
    }
}
