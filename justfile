default:
    @just --list

deps:
    npm ci

run:
    npx shadow-cljs -A:dev clj-run vertlex.shadow/watch
