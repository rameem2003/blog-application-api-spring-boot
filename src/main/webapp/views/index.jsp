<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blog App || Spring Boot</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
  </head>
  <body>
    <jsp:include page="layouts/navber.jsp" />
    <main class="min-h-screen">
      <section class="bg-gradient-to-r from-indigo-900 to-purple-900">
        <div class="relative overflow-hidden">
          <div class="max-w-7xl mx-auto py-16 px-6 sm:px-8 lg:py-28">
            <div class="relative z-10 max-lg:text-center">
              <h1
                class="text-4xl font-bold text-white !leading-tight sm:text-5xl md:text-6xl lg:text-7xl"
              >
                Welcome to
                <span class="text-blue-400 block"> Premium Delights</span>
              </h1>
              <div class="max-w-md md:max-w-3xl mx-auto mt-6">
                <p class="text-lg text-slate-300 leading-relaxed sm:text-xl">
                  Elevate your culinary experience with our exclusive premium
                  services. Indulge in exquisite flavors and extraordinary
                  moments.
                </p>

                <div
                  class="mt-12 flex flex-wrap justify-center gap-6 lg:justify-start lg:mt-16"
                >
                  <a
                    href="#"
                    class="py-3 px-5 text-base rounded-md font-semibold cursor-pointer text-white border border-blue-600 bg-blue-600 hover:bg-blue-700 transition-all focus:outline-none focus-visible:ring-2 focus-visible:ring-blue-500"
                  >
                    Get Started
                  </a>
                  <a
                    href="#"
                    class="py-3 px-5 text-slate-900 text-base font-semibold rounded-md cursor-pointer bg-white border border-slate-300 transition-colors hover:bg-gray-50 focus:outline-none focus-visible:ring-2 focus-visible:ring-blue-500"
                  >
                    Learn More
                  </a>
                </div>
              </div>
            </div>
          </div>

          <div class="lg:absolute lg:inset-y-0 lg:right-0 lg:w-1/2">
            <img
              class="h-56 w-full object-cover sm:h-72 md:h-96 lg:w-full lg:h-full"
              src="https://readymadeui.com/hotel-img.webp"
              alt="hero image"
            />
          </div>
        </div>
      </section>

      <section class="mt-5">
        <div id="blogContainer" class="flex flex-wrap gap-5"></div>
      </section>
    </main>
    <jsp:include page="layouts/footer.jsp" />
  </body>

  <script>
    const blogContainer = document.getElementById("blogContainer");

    const fetchAllBlogs = async () => {
      const response = await fetch("/api/blog/all");

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
</html>
