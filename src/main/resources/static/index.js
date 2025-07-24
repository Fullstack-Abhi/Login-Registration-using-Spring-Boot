function buttonClickEffect(button) {
  button.classList.add("active-glow");
  setTimeout(() => {
    button.classList.remove("active-glow");
  }, 400);
}
