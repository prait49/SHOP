import {fileURLToPath, URL} from 'node:url'

import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
        devServer: {
            proxy: {
                '/api': {
                    target: 'http://localhost:8080/', // Замените на адрес вашего бэкэнда
                    changeOrigin: true,
                    secure: false,
                }
            }
        },
        plugins: [
            vue(),
        ],
        resolve: {
            alias: {
                '@': fileURLToPath(new URL('./src', import.meta.url))
            }
        }
    },
)
