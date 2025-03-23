<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Comprar ingresso</title>
  <link rel="stylesheet" href="../css/todos.css">
  <link rel="stylesheet" href="../css/pages_css/comprar_ingressos.css">
</head>
<body>
<header class="header">
   <a href="../index.jsp"><h1 class="texto-header">Cinemos</h1></a>
</header>

<main class="container">
  <h2>Comprar Ingressos</h2>
  <form id="ticket-form">
    <div class="input-group">
      <input type="text" name="compra" placeholder="Nome do comprador" id="nomeCliente" required>
    </div>
    <div class="input-group">
      <input type="number" name="compra" placeholder="Informe sua idade" id="idadeCliente" required>
    </div>
    <button type="submit" class="btn">Comprar</button>
  </form>
</main>
</body>
</html>
