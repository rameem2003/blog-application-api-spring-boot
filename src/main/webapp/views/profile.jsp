<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Profile</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
  </head>
  <body>
    <jsp:include page="layouts/navber.jsp" />
    <main class="min-h-screen">
      <section class="container mx-auto py-8">
        <div class="w-full mx-auto bg-white p-6 rounded-lg shadow-md">
          <h1 class="text-3xl font-bold mb-4">Profile</h1>

              <!-- User profile content -->
         <div class="mt-4">
            <p class="text-gray-600 mb-2">Name: ${user.name}</p>
            <p class="text-gray-600 mb-2">Email: ${user.email}</p>
            <!-- Add more user information as needed -->
         </div>
        </div>
    </section>
    <section class="mt-5">
   <div id="blogContainer" class="flex flex-wrap gap-5"></div>
 </section>
    </main>
    <jsp:include page="layouts/footer.jsp" />

    
  <script>
    const blogContainer = document.getElementById("blogContainer");

    const fetchAllBlogs = async () => {
      const response = await fetch("/api/blog/user");

      const data = await response.json();

      console.log(data);

      blogContainer.innerHTML = "";
      data.forEach((blog) => {
        blogContainer.innerHTML += `
  <div
   class="bg-white border border-slate-200 shadow-sm w-full max-w-sm rounded-lg mx-auto mt-6 p-4 sm:p-6">
   <div>
      <h3 class="text-slate-900 text-base font-semibold">\${blog.title}</h3>
      <p class="mt-2 text-sm text-slate-600 leading-relaxed">By: \${blog.user.name}</p>
   </div>
   <a href="/blog/\${blog.id}"
      class="inline-block mt-6 py-2 px-3.5 text-sm rounded-md font-semibold cursor-pointer text-white border border-blue-600 bg-blue-600 hover:bg-blue-700 transition-all focus:outline-none focus-visible:ring-2 focus-visible:ring-blue-500">
      Read more
   </a>
</div>`;
      });
    };

    fetchAllBlogs();
  </script>
  </body>
</html>
