<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Profile Page</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
  </head>
  <body>
    <jsp:include page="layouts/navbar.jsp" />
    <section class="container mx-auto px-4 py-10">
      <!-- Profile Section -->
      <div class="bg-white rounded-2xl shadow-md p-8 mb-10">
        <h1 class="text-3xl font-bold text-gray-800">        ${user.name}</h1>

        <p class="text-gray-500 mt-2">        ${user.email}</p>
      </div>

      <!-- Blog Section -->
      <div>
        <h2 class="text-2xl font-bold text-gray-800 mb-6">Posted Blogs</h2>

        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          <!-- Card 1 -->
          <div class="bg-white rounded-2xl shadow-md overflow-hidden">
            <img
              src="https://picsum.photos/500/300?1"
              alt="blog"
              class="w-full h-52 object-cover"
            />

            <div class="p-5">
              <h3 class="text-xl font-semibold mb-2">React Development</h3>

              <p class="text-gray-600 text-sm">
                Learn modern React development with hooks, components, and best
                practices.
              </p>

              <button class="mt-4 bg-black text-white px-4 py-2 rounded-lg">
                Read More
              </button>
            </div>
          </div>

          <!-- Card 2 -->
          <div class="bg-white rounded-2xl shadow-md overflow-hidden">
            <img
              src="https://picsum.photos/500/300?2"
              alt="blog"
              class="w-full h-52 object-cover"
            />

            <div class="p-5">
              <h3 class="text-xl font-semibold mb-2">Next.js Guide</h3>

              <p class="text-gray-600 text-sm">
                Build fast and scalable full-stack applications using Next.js.
              </p>

              <button class="mt-4 bg-black text-white px-4 py-2 rounded-lg">
                Read More
              </button>
            </div>
          </div>

          <!-- Card 3 -->
          <div class="bg-white rounded-2xl shadow-md overflow-hidden">
            <img
              src="https://picsum.photos/500/300?3"
              alt="blog"
              class="w-full h-52 object-cover"
            />

            <div class="p-5">
              <h3 class="text-xl font-semibold mb-2">Node.js Backend</h3>

              <p class="text-gray-600 text-sm">
                Create secure REST APIs with authentication, databases, and
                deployment.
              </p>

              <button class="mt-4 bg-black text-white px-4 py-2 rounded-lg">
                Read More
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>

    <jsp:include page="layouts/footer.jsp" />
  </body>
</html>
