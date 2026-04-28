<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
<main class="min-h-screen flex flex-col items-center justify-center">
    <div class="py-4 px-4 md:px-8">
        <div class="grid items-center gap-6 max-w-6xl w-full lg:grid-cols-2">
            <div
                    class="border border-slate-300 rounded-lg p-6 max-w-md mx-auto shadow-sm md:p-8 lg:mx-0">

                <div class="mb-8">
                    <h1 class="text-slate-900 text-3xl font-bold mb-4">Sign in</h1>
                    <p class="text-slate-600 text-base leading-relaxed">Sign in to your account to access
                        your dashboard and manage your projects.</p>
                    <p class="text-red-500 text-sm mb-4">${error}</p>
                </div>

                <form action="/api/auth/login" method="POST" class="space-y-6">
                    <div>
                        <label for="email"
                               class="mb-2 text-slate-900 font-medium text-sm inline-block">Email</label>
                        <input type="email" id="email" name="email" placeholder="john@readymadeui.com" required
                               class="px-3 py-2.5 text-sm text-slate-900 rounded-md bg-white w-full outline-1 -outline-offset-1 outline-slate-300 focus:outline-2 focus:-outline-offset-2 focus:outline-blue-600"/>
                    </div>
                    <div>
                        <label for="password"
                               class="mb-2 text-slate-900 font-medium text-sm inline-block">Password</label>
                        <input type="password" id="password" name="password" placeholder="" required
                               class="px-3 py-2.5 text-sm text-slate-900 rounded-md bg-white w-full outline-1 -outline-offset-1 outline-slate-300 focus:outline-2 focus:-outline-offset-2 focus:outline-blue-600"/>
                    </div>

                    <button type="submit"
                            class="w-full py-2 px-3.5 text-sm rounded-md font-semibold cursor-pointer tracking-wide text-white border border-blue-600 bg-blue-600 hover:bg-blue-700 transition-all focus:outline-none focus-visible:ring-2 focus-visible:ring-blue-500">
                        Sign in
                    </button>

                    <div class="text-slate-900 text-sm text-center">Don't have an account? <a href="#"
                                                                                              class="text-blue-700 hover:underline ml-1 font-medium focus:outline-none focus-visible:ring-2 focus-visible:ring-blue-500 rounded">Sign
                        up</a>
                    </div>
                </form>
            </div>

            <div class="aspect-[71/50] max-lg:w-4/5 mx-auto">
                <img src="https://readymadeui.com/images/integration-illus.webp" class="w-full object-cover"
                     alt="login img"/>
            </div>
        </div>
    </div>
</main>
</body>
</html>