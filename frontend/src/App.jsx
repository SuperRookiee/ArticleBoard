import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { AuthProvider } from './context/AuthContext'
import ProtectedRoute from './components/ProtectedRoute'
import Navbar from './components/Navbar'
import LoginPage from './pages/LoginPage'
import RegisterPage from './pages/RegisterPage'
import ArticleListPage from './pages/ArticleListPage'
import ArticleDetailPage from './pages/ArticleDetailPage'
import ArticleFormPage from './pages/ArticleFormPage'

export default function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<ArticleListPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/articles/:id" element={<ArticleDetailPage />} />

          <Route element={<ProtectedRoute />}>
            <Route path="/articles/new" element={<ArticleFormPage />} />
            <Route path="/articles/:id/edit" element={<ArticleFormPage />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  )
}
