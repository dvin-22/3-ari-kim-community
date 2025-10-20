document.addEventListener("DOMContentLoaded", function() {
    
    fetch('layout/Header.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('header-placeholder').innerHTML = data;
            profileIcon(); 
        })
        .catch(error => {
            console.error('헤더를 불러오는 중 오류가 발생했습니다:', error);
        });
});