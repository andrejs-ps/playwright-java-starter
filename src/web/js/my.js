$(document).ready(function() {

    // send a copy to yourself
    $('#submit-contact').click(function() {
        if ($('#sendCopy').is(':checked')) {
            var msg = $('#exampleMessage').val();
            $('#copyConfirmation').addClass("alert alert-success").html("<strong>We sent you a copy of your message </strong>: <br/>" + msg);
        }
    });

    // reason for contacting
    $('#contactReason').change(function() {
        var text = $(this).find("option:selected").text();
        if (text === "I'm just bored") {
            $('#boredOption').addClass("alert alert-primary").html("OK, but please make it interesting");
        } else {
            $('#boredOption').html("");
        }
    });

    // Donation
    $('#submit-donation').click(function() {
        var amount = $('#donation').val();
        if (amount < 100) {
            alert("Thank You");
        } else if (amount < 1000) {
            confirm("That's a generous sum! Are you sure?")
        } else {
            prompt("Please confirm you're serious by typing in 'Yes'");
        }
    });

    // clapping
    var clapCount = 0;
    $('#clap-image').click(function() {
        if (clapCount < 1) {
            $('#thank-you').addClass("alert alert-success").html("We appreciate it!");

            clapCount++;
        } else if (clapCount < 2) {
            $('#thank-you-2').addClass("alert alert-warning").html("You can only clap once, but thanks for your enthusiasm.");
            clapCount++;
        }
    });
});