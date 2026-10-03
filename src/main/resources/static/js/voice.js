const button = document.getElementById("start-btn");
const result = document.getElementById("result");

const SpeechRecognition =
    window.SpeechRecognition || window.webkitSpeechRecognition;

if (SpeechRecognition) {

    const recognition = new SpeechRecognition();

    recognition.lang = "en-IN";
    recognition.continuous = false;
    recognition.interimResults = false;

    button.onclick = function () {

        recognition.start();

    };

    recognition.onresult = function (event) {

        const text = event.results[0][0].transcript;

        result.value = text;

    };

    recognition.onerror = function () {

        alert("Voice recognition failed. Please try again.");

    };

} else {

    alert("Your browser does not support Speech Recognition.");

}