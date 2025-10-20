function profileIcon() {
  
  const profileIcon = document.getElementById('profile-icon');
  const profileMenu = document.getElementById('profile-menu');

  if (profileIcon) {
    profileIcon.addEventListener('click', function() {
      const isMenuVisible = profileMenu.classList.contains('show');
      if (isMenuVisible === true) {
        profileMenu.classList.remove('show');
      } 
      else {
        profileMenu.classList.add('show');
      }
    });
  }
}