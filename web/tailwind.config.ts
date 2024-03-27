import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },

      colors: {
        purple: {
          "200": "#941ADF",
          "300": "#B8A6C8",
          "400": "#644471",
          "500": "#22162B",
        },
      
        notation: {
          "yellow": "#F8C630",
          "yellowHover": "#F9D159",
          "green": "#1D9113",
          "orange": "#EC8525",
        },
      }
    },
  },
  plugins: [],
};
export default config;
