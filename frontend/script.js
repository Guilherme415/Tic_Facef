cadastrar = async () => {
    let instituicao

    instituicao = {
        cnpj: document.getElementById("cnpj").value,
        nome: document.getElementById("nome").value,
        cidade: document.getElementById("cidade").value,
    }
    
    await fetch('http://localhost:8080/institution', {
        method: 'POST',
        body: JSON.stringify(instituicao),
        headers: {'Content-Type': 'application/json; charset=UTF-8'}
    })
    .then(response => {
        alert('instituicao cadastrada com sucesso')
    })
    .catch(error => {
        alert('Problema na inserção')
    })
    consulta()
}

consulta = async () => {
    let instituicaos = await fetch('http://localhost:8080/institution')
    .then (response => {
        return response.json() 
    })
    .catch(error => {
        alert('Problema na consulta')
    })
    let saida = ''
    instituicaos.map(instituicao => {
        saida += `<tr> <td> ${instituicao.nome} </td> <td> ${instituicao.cidade} </td> <td>          <i onClick="remove(${instituicao.cnpj})" class="bi bi-trash-fill"></i> </td> <td> <i onClick="atualiza(${instituicao.cnpj}, '${instituicao.nome}', '${instituicao.cidade}')"class="bi bi-pencil-fill"></i> </td> </tr>`
    })
    document.getElementById('corpoTabela').innerHTML = saida
}

remove = async (cnpj) => {
    let confirma = confirm(`Confirma a exclusão do instituicao com código ${cnpj}`)
    if (confirma){ // quer remover
        await fetch(`http://localhost:8080/institution/${cnpj}`, {
            method: 'DELETE'
        }
        )
        .then( response => {
            alert(`Remoção realizada com sucesso`)
        })
        .catch( error => {
            alert(`Serviço indisponível`)
        })
        consulta()
    }
}

atualiza = (cnpj, nome, cidade) => {
    let instituicao

    instituicao = {
        cnpj: cnpj,
        nome: nome,
        cidade: cidade,
    }
    
    await fetch('http://localhost:8080/institution', {
        method: 'PUT',
        body: JSON.stringify(instituicao),
        headers: {'Content-Type': 'application/json; charset=UTF-8'}
    })
    .then(response => {
        alert('instituicao cadastrada com sucesso')
    })
    .catch(error => {
        alert('Problema na inserção')
    })
    consulta()
}