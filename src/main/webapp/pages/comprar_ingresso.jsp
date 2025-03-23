<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Comprar Ingressos</title>
  <link rel="stylesheet" href="../css/todos.css">
  <link rel="stylesheet" href="../css/pages_css/comprar_ingressos.css">
</head>
<body>
<header class="header">
   <a href="../index.jsp"><h1 class="texto-header">Cinemos</h1></a>
</header>

<main class="container">
  <h2>Comprar Ingressos</h2>
  <form id="ticket-form" action="/RedeCinemasApi/ProcessarCompra" method="POST">
    <div class="input-group">
      <label for="quantidadePessoas">Quantidade de pessoas:</label>
      <input type="number" id="quantidadePessoas" name="quantidadePessoas" min="1" max="10" placeholder="Informe a quantidade de pessoas" required>
      <button type="button" class="btn" onclick="gerarCampos()">Gerar Campos</button>
      <button type="button" class="btn btn-reset" onclick="resetarCampos()">Resetar</button>
    </div>

    <div id="pessoas-container"></div>

    <button type="submit" class="btn">Comprar</button>
  </form>
</main>

<script src="../js/comprar_ingressos.js"></script>
</body>
</html>