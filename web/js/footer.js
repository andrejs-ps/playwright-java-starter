(() => {
  'use strict'

document.addEventListener('DOMContentLoaded', () => {
  setTimeout(() => {
    const copyrightElement = document.getElementById('copyright');
    if (copyrightElement) {
      copyrightElement.innerText = `© ${new Date().getFullYear()}`;
    }
  }, 2000);
});

})()