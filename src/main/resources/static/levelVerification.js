fetch('/user-level').then(response => response.json()).then(res => {
    if(res.upgradedLevel) {
        $.toast({
            heading: 'Novo nível alcançado! (' + res.level + ')',
            text: 'Parabéns, suas contribuições nas produções de podcasts e reação a episódios os levaram a um novo patamar, bem vindo ao: ' + res.description,
            icon: 'info',
            loader: true,
            bgColor: res.color,
            hideAfter: 6000,
            position: 'top-right'
        })
    }
})