(() => {
  'use strict'
  const forms = document.querySelectorAll('.needs-validation');
  const checkbox = document.getElementById("heard-about");
  const textarea =  document.getElementById("textarea");

  // Prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }
    }, false);
  })

  const registerBtn = document.getElementById('register');
  registerBtn.addEventListener('click', () => {
    Array.from(forms).forEach(form => {
      form.classList.add('was-validated')
    })
    printToConsole();
  })

  function printToConsole() {
    console.log("Application submitted");
    console.warn("Connection is slow");
    console.error("Something went wrong 1");

    throw new Error("Deliberate error");
  }

  const inputs = document.getElementsByClassName('form-control');
  const clearBtn = document.getElementById('clear');
  clearBtn.addEventListener('click', () => {
    if (confirm('This will clear all inputs. Continue?')) {
      Array.from(inputs).forEach(input => input.value = '');
      checkbox.checked = false;
      textarea.disabled = true;
    }

  });

  const saveBtn = document.getElementById('save');
  saveBtn.addEventListener('click', () => {
    Array.from(inputs).forEach(input => {
      localStorage.setItem(input.getAttribute('id'), input.value);
      localStorage.setItem('heard-about-checked', checkbox.checked);
    });
  });

  document.addEventListener("DOMContentLoaded", function () {
    const isChecked = localStorage.getItem('heard-about-checked') === 'true';
    checkbox.checked = isChecked;
    if(isChecked) {
        textarea.disabled = false;
    }

    Array.from(inputs).forEach(input => {
      let storedValue = localStorage.getItem(input.getAttribute('id'));
      if (storedValue) {
        input.value = storedValue;
      }
    });

  });
})()



$(document).ready(function () {

  $('#heard-about').click(function () {
    if ($("#textarea").attr("disabled")) {
      $('#textarea').removeAttr("disabled");
    } else {
      $('#textarea').prop('disabled', true);
      $('#textarea').val("");
    }
  });
});