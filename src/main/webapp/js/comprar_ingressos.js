function gerarCampos() {
  const containerPessoas = document.getElementById('pessoas-container');
  const quantidade = parseInt(document.getElementById('quantidadePessoas').value, 10);

  containerPessoas.innerHTML = '';

  for (let i = 1; i <= quantidade; i++) {
    const pessoaDiv = document.createElement('div');
    pessoaDiv.className = 'pessoa-group';

    pessoaDiv.innerHTML = `
      <h3>Pessoa ${i}</h3>
      <div class="input-group">
        <label for="nomeCliente${i}">Nome:</label>
        <input type="text" name="nome${i}" id="nomeCliente${i}" placeholder="Nome da pessoa ${i}" required>
      </div>
      <div class="input-group">
        <label for="idadeCliente${i}">Idade:</label>
        <input type="number" name="idade${i}" id="idadeCliente${i}" placeholder="Idade da pessoa ${i}" required>
      </div>
      <div class="input-group">
        <label for="cpfCliente${i}">CPF:</label>
        <input type="text" name="cpf${i}" id="cpfCliente${i}" placeholder="CPF da pessoa ${i}" maxlength="11" required>
      </div>
    `;

    containerPessoas.appendChild(pessoaDiv);
  }
}

function resetarCampos() {
  document.getElementById('quantidadePessoas').value = '';

  const containerPessoas = document.getElementById('pessoas-container');
  containerPessoas.innerHTML = '';
}