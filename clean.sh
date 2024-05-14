#!/usr/bin/env bash
set -euo pipefail

usage() {
  cat <<'EOF'
Clean build artifacts for Java/Python/JS.

Usage:
  ./clean.sh [options]

Options:
  -n, --dry-run   Show what would be deleted without deleting.
  -y, --yes       Do not prompt for confirmation.
  -h, --help      Show this help.

What it removes:
  • Directories: build, out, target, dist, coverage, __pycache__, .pytest_cache,
    .mypy_cache, .ruff_cache, .parcel-cache, .vite, .next, .turbo
  • Files: *.class, *.pyc, *.pyo, *.log, .DS_Store, .eslintcache, coverage.*
EOF
}

DRY_RUN=0
ASSUME_YES=0

while [[ $# -gt 0 ]]; do
  case "$1" in
    -n|--dry-run) DRY_RUN=1; shift ;;
    -y|--yes) ASSUME_YES=1; shift ;;
    -h|--help) usage; exit 0 ;;
    *) echo "Unknown option: $1"; echo; usage; exit 1 ;;
  esac
done

confirm() {
  if [[ "$ASSUME_YES" -eq 1 ]]; then return 0; fi
  read -r -p "This will remove build artifacts. Continue? [y/N] " ans
  [[ "${ans:-}" =~ ^[Yy]$ ]]
}

delete_path() {
  if [[ "$DRY_RUN" -eq 1 ]]; then
    echo "[dry-run] rm -rf -- $1"
  else
    rm -rf -- "$1"
  fi
}

main() {
  confirm || { echo "Aborted."; exit 1; }

  # Directories to remove
  while IFS= read -r -d '' dir; do
    delete_path "$dir"
  done < <(find . -type d \( \
      -name build -o -name out -o -name target -o -name dist -o \
      -name coverage -o -name __pycache__ -o -name .pytest_cache -o \
      -name .mypy_cache -o -name .ruff_cache -o -name .parcel-cache -o \
      -name .vite -o -name .next -o -name .turbo \
    \) -prune -print0)

  # Files to remove
  while IFS= read -r -d '' file; do
    delete_path "$file"
  done < <(find . -type f \( \
      -name '*.class' -o -name '*.pyc' -o -name '*.pyo' -o -name '*.log' -o \
      -name '.DS_Store' -o -name '.eslintcache' -o -name 'coverage.*' \
    \) -print0)

  echo "Done${DRY_RUN:+ (dry-run)}."
}

main "$@"


#rm -rf build
#find . -iname '*.class' | xargs rm
