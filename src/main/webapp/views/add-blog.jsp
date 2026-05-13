<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add New Blog</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
  </head>
  <body>
    <jsp:include page="layouts/navber.jsp" />
    <main class="min-h-screen">
      <div class="max-w-7xl mx-auto py-16 px-6 sm:px-8">
        <h2 class="text-3xl font-bold text-gray-900 mb-8">Add New Blog</h2>
        <form action="/api/blog/add" method="POST">
          <div class="mb-6">
            <label for="title" class="block text-sm font-medium text-gray-700"
              >Title</label
            >
            <input
              type="text"
              id="title"
              name="title"
              class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md"
            />
          </div>
          <div class="mb-6">
            <label for="content" class="block text-sm font-medium text-gray-700"
              >Content</label
            >
            <textarea
              id="content"
              name="content"
              rows="5"
              class="mt-1 focus:ring-blue-500 focus:border-blue-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md"
            ></textarea>
          </div>
          <button
            type="submit"
            class="inline-flex items-center px-4 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500"
          >
            Add Blog
          </button>
        </form>
      </div>
    </main>
    <jsp:include page="layouts/footer.jsp" />
  </body>
</html>
