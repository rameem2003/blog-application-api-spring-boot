<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create New Blog</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
  </head>
  <body>
    <jsp:include page="layouts/navbar.jsp" />
    <main class="min-h-screen">
      <div class="container mx-auto px-4 py-8">
        <h1 class="text-3xl font-semibold mb-4">Create New Blog</h1>
        <form action="/api/blog/add" method="post">
          <div class="mb-4">
            <label for="title" class="block text-gray-700 font-semibold"
              >Title:</label
            >
            <input
              type="text"
              id="title"
              name="title"
              class="w-full p-2 border border-gray-300 rounded-md"
            />
          </div>
          <div class="mb-4">
            <label for="content" class="block text-gray-700 font-semibold"
              >Content:</label
            >
            <textarea
              id="content"
              name="content"
              class="w-full p-2 border border-gray-300 rounded-md"
            ></textarea>
          </div>
          <button
            type="submit"
            class="px-4 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-600"
          >
            Create Blog
          </button>
        </form>
      </div>
    </main>
    <jsp:include page="layouts/footer.jsp" />
  </body>
</html>
