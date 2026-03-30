default:
    @just --list

deps:
    npm ci
    cp node_modules/@fontsource-variable/league-spartan/files/league-spartan-latin-wght-normal.woff2 \
      public/fonts/

run:
    npx shadow-cljs -A:dev clj-run vertlex.shadow/watch
