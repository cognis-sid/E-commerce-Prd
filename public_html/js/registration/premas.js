// JavaScript Document
function changedivbg(objname){
	document.getElementById(objname).style.backgroundColor = '#d9effd';
}

function unchangedivbg(objname){
	document.getElementById(objname).style.backgroundColor = '#f0f0f0';
}

function calculaterisk()
{
	if(document.getElementById('DropDownRegLikelihood').value == 'Select Likelihood' || document.getElementById('DropDownRegSeverity').value == 'Select Severity')
	{
		document.getElementById('TxtRegRiskLevel').value ='';		
	}
	else
	{
		if(document.getElementById('DropDownRegLikelihood').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel').value ='(1) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel').value ='(2) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel').value ='(4) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel').value ='(7) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel').value ='(11) Medium';	
		}
		
		if(document.getElementById('DropDownRegLikelihood').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel').value ='(3) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel').value ='(5) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel').value ='(9) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel').value ='(12) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel').value ='(16) High';	
		}
		
		if(document.getElementById('DropDownRegLikelihood').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel').value ='(6) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel').value ='(10) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel').value ='(13) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel').value ='(17) High';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel').value ='(20) Extreme';	
		}
		
		if(document.getElementById('DropDownRegLikelihood').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity').value == 'C4-Major')
		{
			document.getElementById('TxtRegRiskLevel').value ='(8) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity').value == 'C4-Major')
		{
			document.getElementById('TxtRegRiskLevel').value ='(14) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity').value == 'C4-Majors')
		{
			document.getElementById('TxtRegRiskLevel').value ='(18) High';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity').value == 'C4-Major')
		{
			document.getElementById('TxtRegRiskLevel').value ='(21) Extreme';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity').value == 'C4-Major')
		{
			document.getElementById('TxtRegRiskLevel').value ='(23) Extreme';	
		}
		
		if(document.getElementById('DropDownRegLikelihood').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel').value ='(15) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel').value ='(19) High';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel').value ='(22) Extreme';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel').value ='(24) Extreme';	
		}
		if(document.getElementById('DropDownRegLikelihood').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel').value ='(25) Extreme';	
		}
	}
}


function calculaterisk2()
{
	if(document.getElementById('DropDownRegLikelihood2').value == 'Select Likelihood' || document.getElementById('DropDownRegSeverity2').value == 'Select Severity')
	{
		document.getElementById('TxtRegRiskLevel2').value ='';		
	}
	else
	{
		if(document.getElementById('DropDownRegLikelihood2').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity2').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(1) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity2').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(2) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity2').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(4) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity2').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(7) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity2').value == 'C1-Minor')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(11) Medium';	
		}
		
		if(document.getElementById('DropDownRegLikelihood2').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity2').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(3) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity2').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(5) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity2').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(9) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity2').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(12) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity2').value == 'C2-Moderate')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(16) High';	
		}
		
		if(document.getElementById('DropDownRegLikelihood2').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity2').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(6) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity2').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(10) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity2').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(13) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity2').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(17) High';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity2').value == 'C3-Serious')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(20) Extreme';	
		}
		
		if(document.getElementById('DropDownRegLikelihood2').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity2').value == 'C4-Major')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(8) Low';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity2').value == 'C4-Major')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(14) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity2').value == 'C4-Majors')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(18) High';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity2').value == 'C4-Major')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(21) Extreme';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity2').value == 'C4-Major')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(23) Extreme';	
		}
		
		if(document.getElementById('DropDownRegLikelihood2').value == 'L1-Rare' && document.getElementById('DropDownRegSeverity2').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(15) Medium';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L2-Unlikely' && document.getElementById('DropDownRegSeverity2').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(19) High';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L3-Possible' && document.getElementById('DropDownRegSeverity2').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(22) Extreme';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L4-Likely' && document.getElementById('DropDownRegSeverity2').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(24) Extreme';	
		}
		if(document.getElementById('DropDownRegLikelihood2').value == 'L5-Almost Certain' && document.getElementById('DropDownRegSeverity2').value == 'C5-Catastrophic')
		{
			document.getElementById('TxtRegRiskLevel2').value ='(25) Extreme';	
		}
	}
}
