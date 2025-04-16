// Atualiza o ano no footer automaticamente
document.getElementById('current-year').textContent = new Date().getFullYear();

// Adiciona efeitos aos itens do menu
document.querySelectorAll('.menu-item').forEach(item => {
    item.addEventListener('mouseover', function() {
        this.style.transform = 'scale(1.05)';
    });
    
    item.addEventListener('mouseout', function() {
        this.style.transform = 'scale(1)';
    });
});