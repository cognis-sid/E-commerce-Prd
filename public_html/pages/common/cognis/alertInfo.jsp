<div class="alert alert-primary alert-dismissible show" role="alert" id='alertInfoId'>
  <strong style="font-size:14px;">Info!</strong> 
  <span id="msges" style="font-size:14px;">You should check in on some of those fields below.</span>
  <button type="button" class="close"  aria-label="Close" onclick="$('#alertId').hide()">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<script>
$("#alertInfoId").hide();
function showBarMessageInfo(strMessage) {
	debugger;
		console.log(strMessage+"DDDDDDDDDDD");
		$("#alertInfoId").show();
		 
		$("#msges").html(strMessage);
	}
</script>