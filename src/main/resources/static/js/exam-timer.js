function startTimer(durationInMinutes, displayElement, formElement) {
    let timer = durationInMinutes * 60;
    let minutes, seconds;

    // Wrapper is now a small, dedicated container (see exam_page.html .timer-ring-wrap) —
    // it holds ONLY the number, so the ring centers correctly and never overlaps
    // the "Remaining Time" label above it.
    const wrapper = displayElement.parentElement;
    wrapper.style.cssText += `
        display: flex;
        align-items: center;
        justify-content: center;
        position: relative;
    `;

    // Ring sized to match the compact wrapper (fits a 100x100 container with a small halo)
    const RADIUS = 46;
    const CIRC = 2 * Math.PI * RADIUS;
    const svgNS = "http://www.w3.org/2000/svg";

    const svg = document.createElementNS(svgNS, "svg");
    svg.setAttribute("viewBox", "0 0 100 100");
    svg.style.cssText = `
        position: absolute;
        top: 50%; left: 50%;
        transform: translate(-50%, -50%) rotate(-90deg);
        width: 100px; height: 100px;
        pointer-events: none;
        z-index: 0;
    `;

    // Gradient definition — violet → cyan, matches the site theme
    const defs = document.createElementNS(svgNS, "defs");
    const grad = document.createElementNS(svgNS, "linearGradient");
    grad.setAttribute("id", "timerRingGradient");
    grad.setAttribute("x1", "0%"); grad.setAttribute("y1", "0%");
    grad.setAttribute("x2", "100%"); grad.setAttribute("y2", "100%");
    const stop1 = document.createElementNS(svgNS, "stop");
    stop1.setAttribute("offset", "0%"); stop1.setAttribute("stop-color", "#8b5cf6");
    const stop2 = document.createElementNS(svgNS, "stop");
    stop2.setAttribute("offset", "100%"); stop2.setAttribute("stop-color", "#22d3ee");
    grad.appendChild(stop1); grad.appendChild(stop2);
    defs.appendChild(grad);
    svg.appendChild(defs);

    const track = document.createElementNS(svgNS, "circle");
    track.setAttribute("cx", "50");
    track.setAttribute("cy", "50");
    track.setAttribute("r", RADIUS.toString());
    track.setAttribute("fill", "none");
    track.setAttribute("stroke", "rgba(255,255,255,0.06)");
    track.setAttribute("stroke-width", "5");

    const fill = document.createElementNS(svgNS, "circle");
    fill.setAttribute("cx", "50");
    fill.setAttribute("cy", "50");
    fill.setAttribute("r", RADIUS.toString());
    fill.setAttribute("fill", "none");
    fill.setAttribute("stroke", "url(#timerRingGradient)");
    fill.setAttribute("stroke-width", "5");
    fill.setAttribute("stroke-linecap", "round");
    fill.setAttribute("stroke-dasharray", CIRC.toFixed(2));
    fill.setAttribute("stroke-dashoffset", "0");
    fill.style.transition = "stroke-dashoffset 0.9s linear, stroke 0.5s";
    fill.style.filter = "drop-shadow(0 0 6px rgba(139,92,246,.5))";

    svg.appendChild(track);
    svg.appendChild(fill);
    wrapper.appendChild(svg);

    // Pulse animation style inject
    if (!document.getElementById("_timerStyle")) {
        const style = document.createElement("style");
        style.id = "_timerStyle";
        style.textContent = `
            @keyframes _timerPulse { to { opacity: 0.55; } }
        `;
        document.head.appendChild(style);
    }

    // Style the display element itself — matches site's monospace / accent-cyan
    displayElement.style.cssText += `
        font-family: 'JetBrains Mono', 'Courier New', monospace;
        font-size: 1.3rem;
        font-weight: 700;
        letter-spacing: 2px;
        color: #22d3ee;
        text-shadow: 0 0 14px rgba(34,211,238,0.45);
        position: relative;
        z-index: 1;
        transition: color 0.5s, text-shadow 0.5s;
    `;

    const total = timer;

    const interval = setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        displayElement.textContent = minutes + ":" + seconds;

        // Progress ring update
        fill.style.strokeDashoffset = (CIRC * (1 - timer / total)).toFixed(2);

        // Danger zone — last 60 seconds
        if (timer <= 60) {
            displayElement.style.color = "#f87171";
            displayElement.style.textShadow = "0 0 16px rgba(248,113,113,0.55)";
            displayElement.style.animation = "_timerPulse 0.8s ease-in-out infinite alternate";
            fill.style.stroke = "#f87171";
            fill.style.filter = "drop-shadow(0 0 8px rgba(248,113,113,.6))";
        }

        if (--timer < 0) {
            clearInterval(interval);
            displayElement.textContent = "00:00";
            formElement.submit();
        }
    }, 1000);
}