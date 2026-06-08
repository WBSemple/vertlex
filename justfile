default:
    @just --list

deps:
    npm ci

run:
    npx shadow-cljs watch app
