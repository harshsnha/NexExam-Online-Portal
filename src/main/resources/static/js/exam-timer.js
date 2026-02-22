function startTimer(durationInMinutes, displayElement, formElement) {
    let timer = durationInMinutes * 60;
    let minutes, seconds;

    const interval = setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        displayElement.textContent = minutes + ":" + seconds;

        if (timer <= 60) {
            displayElement.style.color = "#ef4444";
            displayElement.style.textShadow = "0 0 10px rgba(239, 68, 68, 0.5)";
        }

        if (--timer < 0) {
            clearInterval(interval);
            displayElement.textContent = "00:00";
            
            formElement.submit();
        }
    }, 1000);
}