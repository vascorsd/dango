package dango.cli

trait Operations[F[_]]:
  def x = ???

trait RepositoryOps[F[_], G[_], I]:
  def repositories[A]: F[G[A]]
  def repository[A](id: I): F[A]

trait CommitsOps[F[_], G[_]]:
  def commits[A]: F[G[A]]

trait BranchesOps[F[_], G[_], I]:
  def branches[A]: F[G[A]]
  def branch[A](id: I): F[Option[A]]

trait ReleasesOps[F[_], G[_], I, AI]:
  def releases[A]: F[G[A]]
  def release[A](id: I): F[Option[A]]
  def artifacts[A](id: I): F[G[A]]
  def artifact[A](id: I, aid: AI): F[Option[A]]
