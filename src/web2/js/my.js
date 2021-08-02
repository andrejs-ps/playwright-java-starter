$(document).ready(function() {

    // send a copy to yourself
    $('.button-primary').on('click', function() {
        if ($('#sendCopy').is(':checked')) {
        var msg = $('#exampleMessage').val();
        $('#copyConfirmation').html("<strong>We sent you a copy of you message </strong>: <br/> <br/>" + msg);
        }
    });

    // reason for contacting
    $('#contactReason').change(function(){
        var text = $(this).find("option:selected").text();
        if(text === "I'm just bored") {
            $('#boredOption').html("OK, but please make it interesting");
        } else {
            $('#boredOption').html("");
        }
    });
});