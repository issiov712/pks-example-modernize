1. Write code, commit, and note Maven versions are assuming a new patch release based on the latest version tag.
1. When ready, tag as the first ( or next ) release candidate: `git tag -a "0.0.4-rc1" -m "release 0.0.4 candidate 1"`
2. Build the application(s) from this tag point and save away the configuration items.  Note the Maven version is '0.0.4' as if this is the one.
3. If that does not pass muster, make changes and got back to step one (1) to fix the issues.
4. When that passes muster, create the final release candidate tag equal to the last release candidate tag, then push to github, then delete the last release candidate tag.
```
git tag -a 0.0.4 0.0.4-rc2^{} -m "release 0.0.4"
git push origin
git tag -d 0.0.4-rc2
```
