<div class="alert alert-warning alert-dismissible show" role="alert" id='alertId'>
  <strong>Error!</strong> 
  <span id="errorMsg">You should check in on some of those fields below.</span>
  <button type="button" class="close"  aria-label="Close" onclick="$('#alertId').hide()">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<script>
$("#alertId").hide();
function showBarMessageNew(strMessage) {
	debugger;
		console.log(strMessage+"DDDDDDDDDDD");
		$("#alertId").show();
		 
		$("#errorMsg").html(strMessage);
	}
</script>