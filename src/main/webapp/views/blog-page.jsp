<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>      ${blog.title}</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
  </head>
  <body>
    <jsp:include page="layouts/navbar.jsp" />
    <main class="min-h-screen">
      <div class="container mx-auto px-4 py-8">

        <h1 class="text-3xl font-semibold mb-4">
          ${blog.title}
        </h1>

        <p class="text-gray-500 mb-4">
          By ${blog.user.name}
        </p>

        <div class="text-lg">
          ${blog.content}
        </div>
      </div>
    </main>
    <jsp:include page="layouts/footer.jsp" />
  </body>
</html>
