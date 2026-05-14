<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blog Detail</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
  </head>
  <body>
    <jsp:include page="layouts/navber.jsp" />
    <main class="min-h-screen">
      <section class="container mx-auto py-8">
        <div class="w-full mx-auto bg-white p-6 rounded-lg shadow-md">
          <h1 class="text-3xl font-bold mb-4">${blog.title}</h1>
          <p class="text-gray-600 mb-6">By ${blog.user.name}</p>
          <div class="prose">
            ${blog.content}
          </div>
        </div>
      </section>
    </main>
    <jsp:include page="layouts/footer.jsp" />
  </body>
</html>
