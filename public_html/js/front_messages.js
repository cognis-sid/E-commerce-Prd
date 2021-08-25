/******************************************************************************/
/*                                                                            */
/*                         Front End Error Messages                           */
/*                                                                            */
/******************************************************************************/

/*Common Error Messages*/
ECM_GE0001='Database Error Occurred';
ECM_GE0002='Record Locked By Another User';
ECM_GE0003='Division By Zero Error';
ECM_GE0004='No Record Found';
ECM_GE0005='Record deleted By Another User';
ECM_GE0006='Record updated By Another User';
ECM_GE0007='Please select a row';
ECM_GE0008='Invalid Date Format';
ECM_GE0009='Please select a .xls file';
ECM_GE0010='Mandatory value not selected';
ECM_GE0011='Mandatory value not entered';
ECM_GE0012='Please enter a valid number';
ECM_GE0013='Please Save changes first';
ECM_GE0014='No changes to Save';
ECM_GE0015='Invalid Master Code';
ECM_GE0016='Executable file cannot be uploaded';
ECM_GE0017='Error While File Upload';
ECM_GE0018='File name more than 50 characters';
ECM_GE0019='Uploaded Directory does not exist';
ECM_GE0020='File Size should not be greater than {0} MB';
ECM_GE0021='Invalid Template File';
ECM_GE0022='File does not exist on Server';
ECM_GE0023='Please select a File';

/* Common Informations Messages*/
ECM_GI0001='Ready';
ECM_GI0002='{0} Row(s) Retrieved';
ECM_GI0003='Save Successful';
ECM_GI0004='Match Processed';

/* Common Warning Messages*/
ECM_GW0001='Do you wish to delete the selected record(s)?';
ECM_GW0002='Do you wish to cancel?';
ECM_GW0003='Do you wish to send via email?';
ECM_GW0004='Do you wish to save changes?';

/* Screen specific error msg starts */

//ESR_SE0001='Origin Country Blank.';// tanaphol comment from myo 30/07/2013
ESR_SE0001='Please select a origin country.'; // tanaphol add  from myo 30/07/2013
//ESR_SE0002='Destination Country Blank.'; // tanaphol comment from myo 30/07/2013
ESR_SE0002='Please select a destination country.'; // tanaphol add  from myo 30/07/2013
//ESR_SE0003='Port Of Loading Blank.'; // tanaphol comment from myo 1/08/2013
//ESR_SE0004='Port of Discharge Blank.'; // tanaphol comment from myo 1/08/2013
ESR_SE0003='Please select Port of Loading'; // tanaphol add  from myo 1/08/2013
ESR_SE0004='Please select Port of Discharge.'; // tanaphol add  from myo 1/08/2013
ESR_SE0005='Cargo Availability Date Blank.';
ESR_SE0006='Type Field Blank.';
ESR_SE0007='Laden Field Blank row ';
ESR_SE0008='MT Field Blank row ';
//ESR_SE0009='Gross Container Weight Field Blank.'; // teerakan comment from myo 19/07/2013
 // teerakan Add  from myo 19/07/2013
ESR_SE0009='Please provide Gross Container Weight in KG for row'
 // teerakan End  from myo 19/07/2013
//ESR_SE0010='Cargo Description Field Blank.';// tanaphol comment from myo 30/07/2013
ESR_SE0010='Please provide cargo description details.'; // tanaphol add  from myo 30/07/2013
ESR_SE0011='Please select at least one Commodity Group for this shipment.';
//ESR_SE0011='Commodity Group Field Blank.';
ESR_SE0012='Contact is Blank';
ESR_SE0013='Please select destination country which is different from the origin.';

ESR_SE0014='Empty Pickup date cannot be later than Cargo Availability Date'; // teerakan add  from myo 19/07/2013
ESR_SE0015='Cargo Availability Date must be equal or later than the Booking date.'; // teerakan add  from myo 19/07/2013
ESR_SE0016='Empty Pickup date must be same as Booking date or later.'; // tanaphol add  from myo 25/07/2013
ESR_SE0017='Duplicated container size type found in row '; // tanaphol add  from myo 2/08/2013
ESR_SE0018='Cargo Availability Date must be earlier than or on same date as Expected Sailing Date.'; // Yossawat add  from myo 18/10/2013
ESR_SE0019='Desired Arrival Date must be later than the  Cargo Availability Date.'; // yossawat add  from nim 23/09/2013
ESR_SE0020='Please select Cargo Availability Date first.'; // yossawat add  from nim 23/09/2013
ESR_SE0021='*At least one {0} container should be selected for {1} commodity.'; // pratya add  from nim 20/08/2014
ESR_SE0022='*Temperature is required for RF commodity.'; // pratya add  from nim 20/08/2014
ESR_SE0023='*Either UNNO/Variant/IMDG Class or Port Class is mandatory for DG Commodity.'; // pratya add  from nim 20/08/2014
ESR_SE0024='* Length/Width/Height are required for OOG commodity.';// pratya add  from nim 20/08/2014
ESR_SE0025='Booking will be submitted without document attached Click OK to continue.';// pratya add  from nim 20/08/2014
ESR_SE0026='Uploaded document will not be attached for template booking.';// pratya add  from nim 20/08/2014
ESR_SE0027='Please select DG Flashpoint Unit.';// pratya add  from P'Kla 20/08/2014
ESR_SE0028='*For {0} Containers, at least one commodity should have {1} cargo details.</br>Please tick on spacial cargo checkbox and select rate type at commodity details matches with equipment datails.';// pratya add  from nim 20/08/2014
ESR_SE0028_NEW='Equipment and Commodity Details * At Rate Type field should be selected </br>the same type in one booking.(OR system allow to update one rate type in </br> one booking).';// pratya add  from nim 20/08/2014
ESR_SE0029='For OOG rate type, only accept 1 Laden container per booking.';// pratya add  from P'Nim 01/10/2014
ESR_SE0030='For OOG rate type, allow only 1 size/type in booking.';// pratya add  from P'Nim 01/10/2014
ESR_SE0031='At rows {0} Please specific {1}.';// pratya add  from P'Nim 13/10/2014
ESR_SE0032='Contract Party Company require one more rows';// pratya add  from P'Nim 13/10/2014
ESR_SE0033='*{0} is required.'; // pratya add  from nim 20/10/2014
ESR_SE0034='* At rows {0} Effective date must not over than expiry date.'; // pratya add  from nim 21/10/2014
ESR_SE0035='* Please select Represented Company.'; // pratya add  from nim 28/10/2014
ESR_SE0036='Please select at least one {0} for this shipment.';// pratya add  from Kla 06/11/2014
ESR_SE0037='* Please select Quotation Number.';// Watchakorn add from nim 28/12/2015
ESV_SE0038='* At rows {0} Password should be generated before saving.';// Watchakorn add from nim 06/01/2016
ESV_SE0039='Can not assign port pair for user id {0} which there is the same quotation contract party.';


EGM_SE0001='Row {0} Container# can not be Blank';
EGM_SE0002='Row {0} Verified Gross Mass can not be Blank';
EGM_SE0003='Row {0} Gross Cargo Weight can not be Blank';
/* end of error messages */
